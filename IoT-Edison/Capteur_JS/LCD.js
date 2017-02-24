// Load lcd module on I2C
var LCD = require('jsupm_i2clcd');

// Initialize Jhd1313m1 at 0x62 (RGB_ADDRESS) and 0x3E (LCD_ADDRESS) 
var myLcd = new LCD.Jhd1313m1 (0, 0x3E, 0x62);

myLcd.setCursor(0,0);
// RGB Blue
myLcd.setColor(53, 39, 249);
// RGB Red
//myLcd.setColor(255, 0, 0);
myLcd.write('Hello World');  
myLcd.setCursor(1,2);
myLcd.write('Hello World');