package dev.InnocentUdo.ATM_Interface.Services;

public interface ATM_Services {
    public void viewBalance();
    public void withdrawAmount(double withdrawAmount);
    public void depositAmount(double depositAmount );
    public  void viewMiniStatement();
}
