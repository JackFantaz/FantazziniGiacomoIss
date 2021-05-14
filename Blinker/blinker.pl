%====================================================================================
% blinker description   
%====================================================================================
context(ctx_blinker, "localhost",  "TCP", "60000").
 qactor( button_actor, ctx_blinker, "it.unibo.coded.ButtonActor").
  qactor( blinker_actor, ctx_blinker, "it.unibo.blinker_actor.Blinker_actor").
  qactor( led_actor, ctx_blinker, "it.unibo.led_actor.Led_actor").
