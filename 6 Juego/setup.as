package  {
	
	import flash.display.MovieClip;
	import flash.events.Event;
	
	public class setup extends MovieClip {
		
		private var fondo_new: fondo = new  fondo;
		private var piso_new: piso = new  piso;
		private var makima_new: makima = new  makima;
		static var obj2_new: obj2 = new  obj2;
		
		static var puntos_bots_new: puntos_bots = new  puntos_bots();
		static var puntos: Number = 0;
		
 
		public function setup() {
			
			
			// constructor code
			addChild(fondo_new);
			addChild(piso_new);
			addChild(makima_new);
			addChild(obj2_new);
			
			addChild(puntos_bots_new);
			
			
			fondo_new.x=560, fondo_new.y=0;
			piso_new.x=549, piso_new.y=350;
		    makima_new.x=249, makima_new.y=-30;
			obj2_new.x=249, obj2_new.y=310;
			puntos_bots_new.x=60, puntos_bots_new.y=10;
			
			puntos_bots_new.puntos_txt.text = String(puntos);
			this.addEventListener(Event.ENTER_FRAME, actualiza_puntos);
		
		}
		
		public function actualiza_puntos (e: Event) {
			puntos_bots_new.puntos_txt.text = String(puntos);
			
		}

	}
	
}
