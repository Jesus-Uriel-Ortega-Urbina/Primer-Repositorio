package  {
	
	import flash.display.MovieClip;
	import flash.events.Event;
	import flash.events.KeyboardEvent;
	import flash.utils.Timer;
	import flash.events.TimerEvent;
	
	
	public class obj3 extends MovieClip {
		
		
		private var vel: Number=5;
		
		
		

		public function obj3(posX, posY) {
			
			x = posX + -15;
			y = posY +100;
			
			scaleX= .8; 
			scaleY= .8; 
			
			this.addEventListener(Event.ENTER_FRAME, mover); //siempre se ejecuta mi listener como es un frame siempre da movimiento
			
		}
		
		
		
		public function mover(e: Event){
				y+= vel; //muevete en el eje de y 5 pixeles
				
				
				 
				
				
				if (y >=330){
					vel = 0;
					this.removeEventListener(Event.ENTER_FRAME, mover);
					stage.removeChild(this);
					
				}
				
				
				
				if(this.hitTestObject(setup.obj2_new.punto_colision)){
				 
					this.removeEventListener(Event.ENTER_FRAME, mover);
					stage.removeChild(this);
					setup.puntos+=1;
					
				   
				   }
				   
				   
				    if (setup.puntos >= 5) {
					
					   vel = 10;
   
				  }
				  
				    if (setup.puntos >= 10) {
					
					   vel = 15;
   
				  }
				  
				    if (setup.puntos >= 15) {
					
					   vel = 20;
   
				  }
				  
				    if (setup.puntos >= 20) {
					
					   vel = 25;
   
				  }
				  
				    if (setup.puntos >= 25) {
					
					   vel = 30;
   
				  }
				  
				    if (setup.puntos >= 30) {
					
					   vel = 35;
   
				  }
				  
				    if (setup.puntos >= 35) {
					
					   vel = 40;
   
				  }
				  
				    if (setup.puntos >= 40) {
					
					   vel = 45;
   
				  }
				  
				  
				  
				  
				  
				
				  
				 
	
			}
			
			

	}
	
}