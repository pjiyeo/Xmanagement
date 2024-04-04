package project;

public class BankAccount {
    private String customerName;
    private String password;
    private double balance;

    // BankAccount 생성자
    public BankAccount(String customerName, String password, double initialDeposit) {
        this.customerName = customerName;
        this.password = password;
        this.balance = initialDeposit;
    }

    // 잔액 조회
    public double getBalance() {
        return balance;
    }

    // 고객 이름 조회
    public String getCustomerName() {
        return customerName;
    }
    
 // 비밀번호 확인 메서드
    public boolean checkPassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }
    

    // 비밀번호 반환 메서드 추가
    public String getPassword() {
        return password;
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + "원이 입금되었습니다.");
        } else {
            System.out.println("유효하지 않은 금액입니다.");
        }
    }

    // 인출 메서드
    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println(amount + "원이 인출되었습니다.");
            return true;
        } else {
            System.out.println("인출할 수 없습니다. 잔액이 부족하거나 유효하지 않은 금액입니다.");
            return false;
        }
    }
}
