package project;

public class BankService {
    private BankAccount account;
    
    // 고객 유형과 학생 여부를 고려한 계좌 개설 메서드
    public void openAccount(String customerName, String password, double initialDeposit, String customerType, boolean isStudent) {
        // 개인이면서 학생인 경우, 신규 가입 선물로 10,000원 추가
        if ("개인".equals(customerType) && isStudent) {
            initialDeposit += 10000; // 학생인 경우, 10,000원 추가
        }
        account = new BankAccount(customerName, password, initialDeposit);
        System.out.println(customerType + " 계좌가 성공적으로 개설되었습니다. 고객명: " + customerName + ", 초기 입금액: " + initialDeposit);
    }

    // 계좌 개설
    public void openAccount(String customerName, String password, double initialDeposit, boolean isStudent) {
    	 if (isStudent) {
             initialDeposit += 10000; // 학생인 경우, 10,000원 추가
         }
         account = new BankAccount(customerName, password, initialDeposit);
         System.out.println("계좌가 성공적으로 개설되었습니다. 고객명: " + customerName + ", 초기 입금액: " + initialDeposit);
     }


    // 계좌 해지
    public void closeAccount() {
        if (account != null) {
            account = null;
            System.out.println("계좌가 성공적으로 해지되었습니다.");
        } else {
            System.out.println("해지할 계좌가 없습니다.");
        }
    }

    // 계좌 정보 조회
    public void showAccountInfo() {
        if (account != null) {
            System.out.println("고객명: " + account.getCustomerName() + ", 잔액: " + account.getBalance());
        } else {
            System.out.println("개설된 계좌가 없습니다.");
        }
    }
    
    public void closeAccount(String customerName, String password) {
        if (account != null && account.getCustomerName().equals(customerName) && account.checkPassword(password)) {
            account = null;
            System.out.println("계좌가 성공적으로 해지되었습니다.");
        } else {
            System.out.println("계좌 해지를 실패했습니다 정보를 확인해주세요.");
        }
    }
    
 // 계좌 존재 여부 확인 메서드
    public boolean isAccountExist(String customerName, String password) {
        if (account != null && account.getCustomerName().equals(customerName) && account.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    public void deposit(double amount) {
        if (account != null) {
            account.deposit(amount);
        } else {
            System.out.println("계좌가 존재하지 않습니다.");
        }
    }

    // 인출 메서드
    public void withdraw(double amount) {
        if (account != null && account.withdraw(amount)) {
            System.out.println(amount + "원이 성공적으로 인출되었습니다.");
        } else {
            System.out.println("인출 실패: 잔액이 부족하거나 계좌가 존재하지 않습니다.");
        }
    }

    // 잔액 조회 메서드
    public void checkBalance() {
        if (account != null) {
            System.out.println("현재 잔액은 " + account.getBalance() + "원 입니다.");
        } else {
            System.out.println("계좌가 존재하지 않습니다.");
        }
    }
 
    
}
