package Model;

import Interfaces.IEntity;

import java.util.ArrayList;
import java.util.List;

public class PositionsHandler {
    List<IEntity> entities;
    public PositionsHandler(){
        entities = new ArrayList<>();
    }
    public void addEntity(IEntity entity){
        //In factories add entities to this list
        entities.add(entity);
    }
}
