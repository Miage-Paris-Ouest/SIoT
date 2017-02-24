// Load Grove module
var waterSensor = require('jsupm_grovewater');

// Instantiate a Grove Water sensor on digital pin D2
var water = new waterSensor.GroveWater(2);

// Read whether the sensor is wet/dry, waiting one second between readings
function readWaterState()
{
	if (water.isWet())
		console.log("Sensor is wet");
	else
		console.log("Sensor is dry");
}
setInterval(readWaterState, 1000);

// Print message when exiting
process.on('SIGINT', function()
{
	console.log("Exiting...");
	process.exit(0);
});