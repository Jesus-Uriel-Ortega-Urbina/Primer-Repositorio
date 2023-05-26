package  {


	import flash.display.MovieClip;
	import flash.events.Event;
	import flash.events.KeyboardEvent;
	import flash.utils.Timer;
	import flash.events.TimerEvent;
	
	
	public class makima extends MovieClip {
		
		
		private var vel: Number=10;
		private var dir: Number =1;
		private var limite_der=550;
		private var limite_izq=109;
		private var t_cambia: Timer = new Timer (200,0);
		private var dado: Number;
		
		private var t_lanzar : Timer = new Timer(2000,0);

		public function makima() {
			
			
			addEventListener (Event.ENTER_FRAME, actualiza);
			t_cambia.addEventListener(TimerEvent.TIMER, cambia_dir);
			t_cambia.start();
			
		
			t_lanzar.addEventListener(TimerEvent.TIMER, lanza_obj3);
			t_lanzar.start();
		}
		
		public function lanza_obj3 (e: TimerEvent) {
			//trace ("Fuego");
			var obj3_new = new obj3(x, y);
			stage.addChild(obj3_new);
			
		}
		
		
		
		
		public function actualiza(e: Event){
			x += vel * dir;
			if(x>=limite_der){
				dir= -1
			}
			
			if(x<= limite_izq){
				
				dir=1;
			}
		}
		
		public function cambia_dir(e: TimerEvent){
			dado = Math.floor(Math.random() * 8);
			
			switch(dado){
				
				case 1: dir = 1;
				break;
				case 2: dir = -1;
				break;
				
				
				
			}
			
			
		}
		

	}
	
}
