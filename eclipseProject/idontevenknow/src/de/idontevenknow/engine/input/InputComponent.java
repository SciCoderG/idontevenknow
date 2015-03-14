package de.idontevenknow.engine.input;

import de.idontevenknow.engine.Component;

public class InputComponent extends Component{
    
    private int key;
    
    public InputComponent(){
        
    }
    
    public int getKey(){
        return key;
    }
    
    public void setKey(int key){
        this.key = key;
    }
}
