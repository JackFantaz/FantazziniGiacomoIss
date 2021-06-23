%====================================================================================
% carparking description   
%====================================================================================
context(ctxcarparking, "localhost",  "TCP", "60000").
 qactor( businesslogicactor, ctxcarparking, "it.unibo.businesslogicactor.Businesslogicactor").
  qactor( trolleyactor, ctxcarparking, "it.unibo.trolleyactor.Trolleyactor").
  qactor( fanactor, ctxcarparking, "it.unibo.fanactor.Fanactor").
  qactor( thermometeractor, ctxcarparking, "carparking.ThermometerActor").
  qactor( autofan, ctxcarparking, "it.unibo.autofan.Autofan").
