let loading = false;
let lastId = null;
let rowCount = 1;

function loadBoards() {
    if (loading) return;
    loading = true;

    document.getElementById("loading").style.display = "block";

    let url = "/api/boards";
    if (lastId) url += `?lastId=${lastId}`;

    fetch(url)
        .then(res => res.json())
        .then(data => {
            if (!Array.isArray(data)) {
                console.error("데이터 형식이 이상합니다", data);
                return;
            }

            if (data.length === 0) {
                window.removeEventListener("scroll", onScroll);
                document.getElementById("loading").innerText = "모든 게시글을 불러왔습니다.";
                return;
            }

            const tbody = document.getElementById("board-table-body");

            data.forEach(board => {
                const tr = document.createElement("tr");
                tr.innerHTML = `
                    <td>${rowCount++}</td>
                    <td><a href="/board/${board.id}">${board.title}</a></td>
                    <td>${board.writer}</td>
                    <td>${board.createdAt?.substring(0, 16)}</td>
                `;
                tbody.appendChild(tr);
            });

            lastId = data[data.length - 1].id;
        })
        .catch(err => {
            console.error("불러오기 실패:", err);
        })
        .finally(() => {
            loading = false;
            document.getElementById("loading").style.display = "none";
        });
}

function onScroll() {
    if ((window.innerHeight + window.scrollY) >= document.body.offsetHeight - 100) {
        loadBoards();
    }
}

document.addEventListener("DOMContentLoaded", () => {
    loadBoards();
    window.addEventListener("scroll", onScroll);

    setTimeout(() => {
        if (document.body.scrollHeight <= window.innerHeight) {
            loadBoards();
        }
    }, 500);
});
