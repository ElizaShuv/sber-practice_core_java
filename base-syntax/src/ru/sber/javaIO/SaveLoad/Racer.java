package ru.sber.javaIO.SaveLoad;

import ru.sber.javaIO.SaveLoad.Speed.Speed;
import ru.sber.javaIO.SaveLoad.Speed.LowSpeed;
import ru.sber.javaIO.SaveLoad.ImpactResistance.ImpactResistance;
import ru.sber.javaIO.SaveLoad.ImpactResistance.WeakStrength;
import java.io.Serializable;
public class Racer implements Serializable {
    String name;
    int lvl;
    Speed speed;
    ImpactResistance impactResistance;

    public Racer(String name) {
        this.name = name;
        this.lvl = 1;
        this.speed = new LowSpeed();
        this.impactResistance = new WeakStrength();
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public void setSpeed(Speed speed) {
        this.speed = speed;
    }

    public void setImpactResistance(ImpactResistance impactResistance) {
        this.impactResistance = impactResistance;
    }

    @Override
    public String toString() {
        return String.format("Гонщик: %s Уровень: %s \nХарактеристика машины: скоростной уровень: %s, ударопрочность: %s", name, lvl, speed, impactResistance);
    }
}
