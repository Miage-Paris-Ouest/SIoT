var upmBuzzer = require("jsupm_buzzer");// Initialize on GPIO 5
var myBuzzer = new upmBuzzer.Buzzer(5);
var chords = [];
chords.push(upmBuzzer.DO);
chords.push(upmBuzzer.RE);
chords.push(upmBuzzer.MI);
chords.push(upmBuzzer.FA);
chords.push(upmBuzzer.SOL);
chords.push(upmBuzzer.LA);
chords.push(upmBuzzer.SI);
chords.push(upmBuzzer.DO);
chords.push(upmBuzzer.SI);
var chordIndex = 0;

// Print sensor name
console.log(myBuzzer.name());

function melody()
{
    if (chords.length != 0)
    {
        //Play sound for one second
        console.log( myBuzzer.playSound(chords[chordIndex], 1000000) );
        chordIndex++;
        //Reset the sound to start from the beginning. 
        if (chordIndex > chords.length - 1)
			chordIndex = 0;
    }
}
setInterval(melody, 100);

// Print message when exiting
process.on('SIGINT', function()
{
	console.log("Exiting...");
	process.exit(0);
});