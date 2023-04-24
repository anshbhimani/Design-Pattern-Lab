interface Commandar
{
    void registerArmedUnits(ArmedUnit soldierUnit, ArmedUnit tankUnit);
    void setAttackStatus(boolean attackStatus);
    boolean canAttack();
    void startAttack(ArmedUnit armedUnit);
    void ceaseAttack(ArmedUnit armedUnit);
}

class CommandarImplementation implements Commandar
{
    ArmedUnit soldierUnit, tankUnit;
    boolean attackStatus = true;
    
    @Override
    public void registerArmedUnits(ArmedUnit soldierUnit,ArmedUnit tankUnit)
    {
        this.soldierUnit = soldierUnit;
        this.tankUnit = tankUnit;
    }

    @Override
    public void setAttackStatus(boolean attackStatus) 
    {
        this.attackStatus = attackStatus;
    }

    @Override
    public void startAttack(ArmedUnit armedUnit) {
        setAttackStatus(true);
    }
    
    public void ceaseAttack(ArmedUnit armedUnit)
    {
        setAttackStatus(false);
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


class MediatorPatternDemo
{
    public static void main(String[] args) throws Exception
    {
        Commander commander = new CommandarImplementation();
        ArmedUnit soldierUnit = new SoldierUnit(commander);
        ArmedUnit tankUnit = new TankUnit(commander);

        commander.registerArmedUnits(soldierUnit, tankUnit);
        commander.startAttack(soldierUnit);
        commander.ceaseAttack(soldierUnit);
        commander.startAttack(soldierUnit);
    }
}