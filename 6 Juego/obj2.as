package  {
	
	import flash.display.MovieClip;
	import flash.events.Event;
	import flash.events.KeyboardEvent;
	
	
	public class obj2 extends MovieClip {
		
		
		private var der: Boolean = false;
		private var izq: Boolean = false;
		private var vel: int=5;
		
		

		public function obj2() {
			// constructor code
			addEventListener (Event.ENTER_FRAME, motor);
			
		}
		
		public function motor(e: Event): void {
			
			if (der && x<430)  { //Agregue un limite a la derecha de 550
				
				x+=10;
			
				//agregar un limite para q no sobre pase la pared tanto 
			}
			
			
			
			if(x< -10){ //el if base del limite que en este caso detiene en la izquierda
				
			}  //aqui acaba
		
			
			else if (izq) {
				 
				 x -= 10; //agregar un limite para q no sobre pase la pared tanto 
			}
			
			
			
		
			
			
			
			
			controles();
			
		}
		
		public function controles() {
			
			stage.addEventListener(KeyboardEvent.KEY_DOWN, keydown);
			stage.addEventListener(KeyboardEvent.KEY_UP, keyup);
			
		}
		
		public function keydown(e: KeyboardEvent): void { //aprieta tecla
			switch (e.keyCode) {
				
				case 39: //tecla D en ASCCI
				der= true;
				break;
				
				case 37: //TECLA A EN ASCCI
				izq= true;
				break;
			}
			
			
		}
		//A
		
		public function keyup(e: KeyboardEvent): void { //keyup libera tecla
			switch (e.keyCode) {
				
				case 39: //tecla D en ASCCI
				der= false;
				break;
				
				case 37: //TECLA A EN ASCCI
				izq= false;
				break;
			}
			
		}
		

	}
	
} 


