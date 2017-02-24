var rotaryEncoder = require("jsupm_rotaryencoder");
// Instantiate a Grove Rotary Encoder, using signal pins D2 and D3
var myRotaryEncoder = new rotaryEncoder.RotaryEncoder(2, 3);

var myInterval = setInterval(function()
{
	console.log("Position: " + myRotaryEncoder.position());
}, 100);

// When exiting: clear interval and print message
process.on('SIGINT', function()
{
	clearInterval(myInterval);
	console.log("Exiting...");
	process.exit(0);
});