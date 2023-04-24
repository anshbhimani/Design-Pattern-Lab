interface State
{
    public void stateHandling();
    public void changeState(StateChange state);
}

class StateChange 
{
    private State currentState;

    public StateChange()
    {
        currentState = new State1(); 
    }

    public void setState(State new_state)
    {
        currentState = new_state;
    }

    public void display() {
        currentState.stateHandling();
    }

    public void changeState() {
        currentState.changeState(this);
    }
}

class State1 implements State
{
    @Override
    public void stateHandling() {
        System.out.println("Welcome to State 1\n");
        System.out.println("Initial State1 - can move to State2");
    }

    @Override
    public void changeState(StateChange newState)
    {
        System.out.println("Changing from State1 to State2");
        newState.setState(new State2());
    }
}

class State2 implements State
{
    @Override
    public void stateHandling() {
        System.out.println("Welcome State to State 2\n");
        System.out.println("Initial State2 - can move to State3");
    }

    @Override
    public void changeState(StateChange newState)
    {
        System.out.println("Changing from State2 to State3");
        newState.setState(new State3());
    }
}

class State3 implements State
{
    @Override
    public void stateHandling() {
        System.out.println("Welcome State to State 3\n");
        System.out.println("Initial State3 - last state -can move to Initial State State1");
    }

    @Override
    public void changeState(StateChange newState)
    {
        System.out.println("Changing from State3 to State1");
        newState.setState(new State1());
    }
}

class Context
{
    private State current_State;

    public Context(State s)
    {
        current_State = s;
    }

    public void setState(State s)
    {
        current_State = s;
    }

    public State getState()
    {
        return current_State;
    }

    public void performAction()
    {
        current_State.stateHandling();
    }
}

public class StatePatternDemo
{
    public static void main(String[] args) 
    {
       StateChange state_change = new StateChange();

       state_change.display();

       state_change.changeState();
       state_change.display();

       state_change.changeState();
       state_change.display();
    }
}