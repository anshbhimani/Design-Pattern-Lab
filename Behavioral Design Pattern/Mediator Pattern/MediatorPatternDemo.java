interface Commandar
{
    void registerArmedUnits(ArmedUnit soldierUnit, ArmedUnit tankUnit);
    void setAttackStatus(boolean attackStatus);
    boolean canAttack();
    void startAttack(ArmedUnit armedUnit);
    void ceaseAttack(ArmedUnit armedUnit);
}

class CommandarImplementation implements Commandar {
    ArmedUnit soldierUnit, tankUnit;
    boolean attackStatus;

    @Override
    public boolean canAttack() {
        return attackStatus;
    }

    @Override
    public void registerArmedUnits(ArmedUnit soldierUnit, ArmedUnit tankUnit) {
        this.soldierUnit = soldierUnit;
        this.tankUnit = tankUnit;
    }

    @Override
    public void setAttackStatus(boolean attackStatus) {
        this.attackStatus = attackStatus;
    }

    @Override
    public void startAttack(ArmedUnit armedUnit) {
        setAttackStatus(true);
        System.out.println(armedUnit.getClass().getSimpleName() + " Started Attacking !!!");
    }

    @Override
    public void ceaseAttack(ArmedUnit armedUnit) {
        setAttackStatus(false);
        System.out.println(armedUnit.getClass().getSimpleName() + " Stopped Attacking !!!");
    }
}


interface ArmedUnit
{
    void attack();
    void stopAttack();
}

class SoldierUnit implements ArmedUnit
{
    private Commandar commandar;

    public SoldierUnit(Commandar commandar)
    {
        this.commandar = commandar;
    }

    @Override
    public void attack()
    {
        if(commandar.canAttack())
        {
            System.out.println("SoldierUnit Attacking !!!");
            commandar.setAttackStatus(false);
        }

        else
        {
            System.out.println("SoldierUnit cannot attack");
            System.out.println("Other Units Attack");
        }
    }

    @Override
    public void stopAttack()
    {
        System.out.println("SoldierUnit Stopped Attacking !!!");
        commandar.setAttackStatus(false);
    }
}

class TankUnit implements ArmedUnit
{
    private Commandar commandar;

    public TankUnit(Commandar commandar)
    {
        this.commandar=commandar;
    }

    @Override
    public void attack()
    {
        if(commandar.canAttack())
        {
            System.out.println("TankUnit Attacking !!!");
            commandar.setAttackStatus(false);
        }

        else
        {
            System.out.println("TankUnit cannot attack");
            System.out.println("Other Units Attack");
        }
    }

    @Override
    public void stopAttack()
    {
        System.out.println("TankUnit Stopped Attacking !!!");
        commandar.setAttackStatus(false);
    }
}


class MediatorPatternDemo
{
    public static void main(String[] args) throws Exception
    {
        Commandar commandar = new CommandarImplementation();
        ArmedUnit soldierUnit = new SoldierUnit(commandar);
        ArmedUnit tankUnit = new TankUnit(commandar);

        commandar.registerArmedUnits(soldierUnit, tankUnit);
        commandar.startAttack(soldierUnit);
        commandar.startAttack(tankUnit);

        commandar.ceaseAttack(soldierUnit);
        commandar.ceaseAttack(tankUnit);
    }
}