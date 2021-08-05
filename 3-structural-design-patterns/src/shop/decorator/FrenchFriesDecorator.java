package decorator;

import component.FoodComponent;

public class FrenchFriesDecorator extends FoodDecorator {
      
  public FrenchFriesDecorator(FoodComponent _food) {
    super(_food);
  }

  @Override
  public float getPrice() {
    return super.getPrice() + 100;
  }

}
