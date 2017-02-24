//Load Grove Moisture module
var grove_moisture = require('jsupm_grovemoisture');

// Instantiate a Grove Moisture sensor on analog pin A0
var myMoistureObj = new grove_moisture.GroveMoisture(0);

// Values (approximate):
// 0-300,   sensor in air or dry soil
// 300-600, sensor in humid soil
// 600+,    sensor in wet soil or submerged in water
// Read the value every second and print the corresponding moisture level
setInterval(function()
{
	var result;
	var moisture_val = parseInt(myMoistureObj.value());
	if (moisture_val >= 0 && moisture_val < 300)
		result = "Dry";
	else if (moisture_val >= 300 && moisture_val < 600)
		result = "Moist";
	else
		result = "Wet";
	console.log("Moisture value: " + moisture_val + ", " + result);
}, 1000);

// Print message when exiting
process.on('SIGINT', function()
{
	console.log("Exiting...");
	process.exit(0);
});