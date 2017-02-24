// Load Grove module
var groveSensor = require('jsupm_grove');

// Create the button object using GPIO pin 0
var button = new groveSensor.GroveButton(2);

if (button == null) {// Read the input and print, waiting one second between readings
	console.log(button.name() + " is unplug" );
} 

else{
	function readButtonValue() {
	    console.log(button.name() + " value is " + button.value());
	}
	setInterval(readButtonValue, 1000)
};

