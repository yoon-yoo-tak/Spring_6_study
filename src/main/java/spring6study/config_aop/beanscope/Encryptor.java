package spring6study.config_aop.beanscope;

class Encryptor {
    public Encryptor() {
        System.out.println("Encryptor 객체 생성됨!");
    }

    public String encrypt(String data) {
        return "Encrypted[" + data + "]";
    }
}