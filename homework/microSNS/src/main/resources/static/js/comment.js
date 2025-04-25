document.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById("comment-form");

    form.addEventListener("submit", function (e) {
        e.preventDefault();

        const formData = new FormData(form);
        const url = form.getAttribute("action");

        fetch(url, {
            method: "POST",
            body: formData
        })
            .then(res => {
                if (!res.ok) throw new Error("서버 응답 오류");
                return res.json();
            })
            .then(comment => {
                const commentList = document.getElementById("comment-list");
                const newEl = document.createElement("div");
                newEl.classList.add("comment");
                newEl.setAttribute("id", `comment-${comment.id}`);
                const formattedTime = formatDateTime(comment.createdAt);
                newEl.innerHTML = `
                <p><strong>${comment.writer}</strong> <span style="color:black;">${formattedTime}</span></p>
                <p>${comment.content}</p>
                <div class="comment-actions">
                    <button class="btn-edit" data-id="${comment.id}">수정</button>
                    <button class="btn-delete" data-id="${comment.id}">삭제</button>
                    <div class="edit-box hidden">
                        <textarea class="edit-content">${comment.content}</textarea>
                        <input type="password" class="edit-password" placeholder="비밀번호" />
                        <button class="edit-confirm" data-id="${comment.id}">수정 완료</button>
                    </div>
                    <div class="delete-box hidden">
                        <input type="password" class="delete-password" placeholder="비밀번호" />
                        <button class="delete-confirm" data-id="${comment.id}">삭제 확인</button>
                    </div>
                </div>
            `;
                commentList.appendChild(newEl);
                form.reset();
                bindCommentButtons(newEl);
            })
            .catch(err => {
                alert("댓글 작성 중 오류 발생");
                console.error(err);
            });

    });

    document.querySelectorAll(".comment").forEach(comment => {
        bindCommentButtons(comment);
    });
});

function bindCommentButtons(commentEl) {
    const id = commentEl.getAttribute("id").replace("comment-", "");

    const editBtn = commentEl.querySelector(".btn-edit");
    const deleteBtn = commentEl.querySelector(".btn-delete");
    const editConfirmBtn = commentEl.querySelector(".edit-confirm");
    const deleteConfirmBtn = commentEl.querySelector(".delete-confirm");

    if (editBtn) {
        editBtn.addEventListener("click", () => {
            const editBox = commentEl.querySelector(".edit-box");
            editBox.classList.toggle("hidden");
        });
    }

    if (deleteBtn) {
        deleteBtn.addEventListener("click", () => {
            const deleteBox = commentEl.querySelector(".delete-box");
            deleteBox.classList.toggle("hidden");
        });
    }

    if (editConfirmBtn) {
        editConfirmBtn.addEventListener("click", () => {
            const content = commentEl.querySelector(".edit-content").value;
            const password = commentEl.querySelector(".edit-password").value;

            fetch(`/comments/${id}/edit`, {
                method: "POST",
                headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
                body: new URLSearchParams({ password, content })
            })
                .then(res => res.json())
                .then(data => {
                    if (data.success) {
                        alert("수정 완료");
                        location.reload();
                    } else {
                        alert("비밀번호가 일치하지 않습니다.");
                    }
                });
        });
    }

    if (deleteConfirmBtn) {
        deleteConfirmBtn.addEventListener("click", () => {
            const password = commentEl.querySelector(".delete-password").value;

            fetch(`/comments/${id}/delete`, {
                method: "POST",
                headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
                body: new URLSearchParams({ password })
            })
                .then(res => res.json())
                .then(data => {
                    if (data.success) {
                        alert("삭제 완료");
                        commentEl.remove(); // 바로 삭제
                    } else {
                        alert("비밀번호가 일치하지 않습니다.");
                    }
                });
        });
    }
}

function formatDateTime(isoString) {
    const date = new Date(isoString);
    const yyyy = date.getFullYear();
    const MM = String(date.getMonth() + 1).padStart(2, '0');
    const dd = String(date.getDate()).padStart(2, '0');
    const HH = String(date.getHours()).padStart(2, '0');
    const mm = String(date.getMinutes()).padStart(2, '0');
    return `${yyyy}-${MM}-${dd} ${HH}:${mm}`;
}
