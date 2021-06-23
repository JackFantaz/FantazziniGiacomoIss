%====================================================================================
% carparking description   
%====================================================================================
context(ctxcarparking, "localhost",  "TCP", "60000").
 qactor( sonaractor, ctxcarparking, "carparking.SonarActor").
  qactor( weightactor, ctxcarparking, "carparking.WeightActor").
  qactor( thermometeractor, ctxcarparking, "carparking.ThermometerActor").
  qactor( businesslogicactor, ctxcarparking, "it.unibo.businesslogicactor.Businesslogicactor").
  qactor( parkservicegui, ctxcarparking, "it.unibo.parkservicegui.Parkservicegui").
  qactor( trolleyactor, ctxcarparking, "it.unibo.trolleyactor.Trolleyactor").
  qactor( fanactor, ctxcarparking, "it.unibo.fanactor.Fanactor").
  qactor( servicestatusactor, ctxcarparking, "it.unibo.servicestatusactor.Servicestatusactor").
  qactor( temperaturesentinelactor, ctxcarparking, "it.unibo.temperaturesentinelactor.Temperaturesentinelactor").
  qactor( outdoorsentinelactor, ctxcarparking, "it.unibo.outdoorsentinelactor.Outdoorsentinelactor").
