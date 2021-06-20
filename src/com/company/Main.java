package com.company;

interface Phone{
    public void power380On();
    public void power380Off();
}
interface PhoneRus{
    public void power220On();
    public void power220Off();
}
class SamsungBas implements Phone{

    @Override
    public void power380On(){
        System.out.println("SamsungBas is charging");
    }
    @Override
    public void power380Off(){
        System.out.println("SamsungBas is not charging");
    }}
class SamsungRus implements PhoneRus{

    @Override
    public void power220On(){
        System.out.println("SamsungRus is charging");
    }
    @Override
    public void power220Off(){
        System.out.println("SamsungRus is charging");
    }}
class PowerAdapter implements Phone{
    PhoneRus phoneRus;

    public PowerAdapter(PhoneRus phoneRus){
        this.phoneRus = phoneRus;
    }
    @Override
    public void power380On(){
        phoneRus.power220On();
    }
    @Override
    public void power380Off(){
        phoneRus.power220Off();
    }}
class CentralProcessor{
    private Phone power;
    public CentralProcessor(Phone power){
        this.power = power;
    }
    public void charge(){
        power.power380On();
        power.power380Off();
    }}
public class Main{
    public static void main(String[] args){
        Phone samsungBas = new SamsungBas();
        CentralProcessor cp = new CentralProcessor(samsungBas);
        cp.charge();

        PowerAdapter samsungRus = new PowerAdapter(new SamsungRus());
        CentralProcessor cpRus = new CentralProcessor(samsungRus);
        cpRus.charge();
    }}
