package build;

import components.identity.*;
import components.internet.*;
import components.micro.*;
import components.weight.*;
import components.storage.*;
import components.display.*;
import components.controller.*;
import hardware.*;
import server.*;


class GoldPackageBuilder implements PackageBuilderInterface {

  private HardwareInterface hardware;
  private ServerInterface server;
  
  GoldPackageBuilder() throws Exception {      
    System.out.println("GoldPackageBuilder created");
  }

  @Override
  public void setupHardware() throws Exception {
    this.hardware = new Hardware();

    MicroInterface micro = MicroFactory.create("ArduinoMega");
    this.hardware.setMicro(micro);

    WeightSensorInterface weightSensor = WeightSensorFactory.create("WeightModule");
    this.hardware.setWeightSensor(weightSensor);

    IdentityInterface identityCard = IdentityFactory.create("RFID");
    this.hardware.setIdentityCard(identityCard);

    StorageInterface storage = StorageFactory.create("SDCard");
    this.hardware.setStorage(storage);

    DisplayInterface display = DisplayFactory.create("LED");
    this.hardware.setDisplay(display);

    ControllerInterface controller = ControllerFactory.create("Button");
    this.hardware.setController(controller);

    System.out.println("Device built successfully!");
  }

  @Override
  public void addInternet(String _internetType) throws Exception {
    if (_internetType == "Ethernet")
      throw new Exception("ERROR: Internet is not compatible with hardware");
    InternetInterface internet = InternetFactory.create(_internetType);
    this.hardware.setInternet(internet);
    System.out.println("System successfully connected to the internet!");
  }

  @Override
  public void addServer(String _serverType) throws Exception {
    this.server = ServerFactory.create(_serverType);
    System.out.println("Server setup successful!");
  }

  @Override
  public HardwareInterface getHardware() {
    return this.hardware;
  }

  @Override
  public ServerInterface getServer() {
    return this.server;
  }

}
