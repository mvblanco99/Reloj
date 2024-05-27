/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javax.swing.JOptionPane;

/**
 *
 * @author Manuel Blanco
 */
public class Reloj {
    
    private enum TimePeriod {
        AM,
        PM
    }
    
    private enum TimeUnit {
        SECOND,
        MINUTE,
        HOUR
    }
    
    private int second;
    private int minute;
    private int hour;
    private TimePeriod period;
    
    //Valores que usaremos para mantener control al asignar 
    //valores a los segudos, minutos y horas
    private final int valueMaxMinutesAndSecond = 60;
    private final int valueMaxHour = 12;
    private final int valueMinMinutesAndSecond = 0;
    private final int valueMinHour = 1;
    
    public void initReloj(){
       
        setSecond(getSecond() + 1);
        
        if(getSecond() == valueMaxMinutesAndSecond){
            setSecond(valueMinMinutesAndSecond);
            setMinute(getMinute() + 1);
        }
        
        if(getMinute() == valueMaxMinutesAndSecond){
            setMinute(valueMinMinutesAndSecond);
            setHour(getHour() + 1);
        }
        
        if(getHour() > valueMaxHour){
            setHour(valueMinHour);
            if(getPeriod() == TimePeriod.AM){
                setPeriod(PeriodPM());
            }else{
                setPeriod(PeriodAM());
            }
        }
        
    }
    
    public void resetReloj(){
        setSecond(0);
        setMinute(0);
        setHour(12);
        setPeriod(PeriodAM());
    }
    
    public boolean checkValuesReloj(){
        boolean statusCheck = true;
        
        if(!checkInsertedValue(getHour(), TimeUnit.HOUR)){
            statusCheck = false;
            JOptionPane.showMessageDialog(null, "el valor insertado para la hora es invalido");
        }
        
        if(!checkInsertedValue(getMinute(), TimeUnit.MINUTE)){
            statusCheck = false;
            JOptionPane.showMessageDialog(null, "el valor insertado para los minutos es invalido");
        }
        
        if(!checkInsertedValue(getSecond(), TimeUnit.SECOND)){
            statusCheck = false;
            JOptionPane.showMessageDialog(null, "el valor insertado para los segundos es invalido");
        }
        
        return statusCheck;
    }
    
    private boolean checkInsertedValue(int value, TimeUnit type){
        boolean statusCheck = true;
        
        int valueMax = (type == TimeUnit.MINUTE || type == TimeUnit.SECOND) ? valueMaxMinutesAndSecond : valueMaxHour;
        int valueMin = (type == TimeUnit.MINUTE || type == TimeUnit.SECOND) ? valueMinMinutesAndSecond : valueMinHour;
        if(value > valueMax || value < valueMin){
            statusCheck = false;
        }
        return statusCheck;
    };
    
    public TimePeriod PeriodAM(){
        return TimePeriod.AM;
    }
    
    public TimePeriod PeriodPM(){
        return TimePeriod.PM;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getSecond() {
        return second;
    }

    public int getMinute() {
        return minute;
    }

    public int getHour() {
        return hour;
    }
    
    public void setPeriod(TimePeriod period) {
        this.period = period;
    }

    public TimePeriod getPeriod() {
        return period;
    }
    
}
