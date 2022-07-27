package com.example.phonecomparator.model

import com.google.gson.annotations.SerializedName

data class ProductResult(
    val Success: Int,
    val data: Data,
    val error: ErrorSmart,
    val message: String
)

data class Data(
    val product: List<Product>
)

data class Product(
//    val Camera: Camera,
    val Category: String,
    val Design: Design,
//    val Display: Display,
//    val Image: Image,
//    val Inside: Inside,
    val Product: ProductX,
//    val Yes: Yes,
    val _id: String
)

//data class Camera(
//    @SerializedName("Back Camera") val BackCamera: BackCamera
//    @SerializedName("Back Camera II") val BackCameraII: BackCameraII,
//    @SerializedName("Back Camera III") val BackCameraIII: BackCameraIII,
//    @SerializedName("Back Camera IV") val BackCameraIV: BackCameraIV,
//    @SerializedName("Back Camera V") val BackCameraV: BackCameraV,
//    @SerializedName("Front Camera") val FrontCamera: FrontCamera,
//    @SerializedName("Front Camera II") val FrontCameraII: FrontCameraII,
//    @SerializedName("BFront Camera III") val FrontCameraIII: FrontCameraIII
//)

data class Design(
    @SerializedName("Color(s)") val Colors: String,
    val Height: String,
    @SerializedName("IP Rating") val IPRating: String,
    val Thickness: String,
    val Weight: String,
    val Width: String
//    val Keyboard: Keyboard,
//    val Keyboard II: KeyboardII

)

//data class Display(
//    val Bezel Width: String,
//    val Color Depth: String,
//    val Diagonal: String,
//    val Dynamic Range: String,
//    val Glass: String,
//    val Height: String,
//    val Illumination: String,
//    val LCD Mode: String,
//    val Module: String,
//    val Notch(es): String,
//    val Number of Colors: String,
//    val Pixel Density: String,
//    val Pixel Size: String,
//    val Puch holes(s): String,
//    val Refresh Rate: String,
//    val Resolution (H x W): String,
//    val Screen: Screen,
//    val Screen to Body Ratio: String,
//    val Subpixels: String,
//    val Touch Point(s): String,
//    val Touch Points: String,
//    val Touch screen Type: String,
//    val Type: String,
//    val Width: String
//)
//
//data class Image(
//    val Back: Any,
//    val Front: String
//)
//
//data class Inside(
//    val Battery: Battery,
//    val Cellular: Cellular,
//    val Location: Location,
//    val Processor: Processor,
//    val RAM: RAM,
//    val SAR: SAR,
//    val Sensor(s): Sensors,
//    val Software: Software,
//    val Storage: Storage,
//    val Wireless: Wireless
//)
//
data class ProductX(
    val Brand: String,
    val Model: String,
    val Version: String
)
//
//data class Yes(
//    val Audio: Audio,
//    val Experiences: Experiences,
//    val Peripheral(s): Peripherals,
//    val Port(s): Ports
//)
//
data class BackCamera(
    @SerializedName("Aperture (T)") val ApertureT: String,
    @SerializedName("Aperture (W)") val ApertureW: String,
    @SerializedName("Equivalent Focal Length") val EqFocalLength: String,
    val Features: String,
    val Flash: String,
    val Focus: String,
    @SerializedName("Image Format") val ImageFormat: String,
    @SerializedName("Minimum Focal Length") val MinFocalLength: String,
    val Module: String,
    @SerializedName("Pixel Size") val PixelSize: String,
    @SerializedName("Resolution") val resolution: String,
    @SerializedName("Resolution(H x W)") val ResolutionHxW: String,
    @SerializedName("Sensor") val sensor: String,
    @SerializedName("Sensor Format") val SensorFormat: String,
    @SerializedName("Video Format") val VideoFormat: String,
    @SerializedName("Video Resolution") val VideoResolution: String,
    val Zoom: String
)
//
//data class BackCameraII(
//    val Aperture (W): String,
//    val Equivalent Focal Length: String,
//    val Features: String,
//    val Focus: String,
//    val Module: String,
//    val Pixel Size: String,
//    val Resolution: String,
//    val Sensor: String,
//    val Sensor Format: String
//)
//
//data class BackCameraIII(
//    val Aperture (W): String,
//    val Equivalent Focal Length: String,
//    val Features: String,
//    val Focus: String,
//    val Pixel Size: String,
//    val Resolution: String,
//    val Sensor: String,
//    val Sensor Format: String
//)
//
//data class BackCameraIV(
//    val Aperture (W): String,
//    val Equivalent Focal Length: String,
//    val Features: String,
//    val Focus: String,
//    val Pixel Size: String,
//    val Resolution: String,
//    val Sensor: String
//)
//
//data class BackCameraV(
//    val Aperture (W): String,
//    val Features: String,
//    val Focus: String,
//    val Pixel Size: String,
//    val Resolution: String,
//    val Sensor: String
//)
//
//data class FrontCamera(
//    val Aperture (W): String,
//    val Features: String,
//    val Flash: String,
//    val Focus: String,
//    val Image Format: String,
//    val Minimum Focal Length: String,
//    val Module: String,
//    val Pixel Size: String,
//    val Resolution: String,
//    val Resolution (H x W): String,
//    val Sensor: String,
//    val Sensor Format: String,
//    val Video Format: String,
//    val Video Resolution: String
//)
//
//data class FrontCameraII(
//    val Aperture (W): String,
//    val Pixel Size: String,
//    val Resolution: String,
//    val Sensor: String
//)
//
//data class FrontCameraIII(
//    val Aperture (W): String,
//    val Resolution: String,
//    val Sensor: String
//)
//
//data class Keyboard(
//    val Backlight: String,
//    val Design: String,
//    val Keys: String
//)
//
//data class KeyboardII(
//    val Backlight: String,
//    val Design: String,
//    val Keys: String
//)
//
//data class Screen(
//    val Color Depth: String,
//    val Diagonal: String,
//    val Dynamic Range: String,
//    val Glass: String,
//    val Height: String,
//    val Illumination: String,
//    val LCD Mode: String,
//    val Module: String,
//    val Number of Colors: String,
//    val Pixel Density: String,
//    val Pixel Size: String,
//    val Resolution (H x W): String,
//    val Subpixels: String,
//    val Type: String,
//    val Width: String
//)
//
//data class Battery(
//    val Capacity: String,
//    val Charging Power: String,
//    val Current: String,
//    val Energy: String,
//    val Life: String,
//    val Power IC: String,
//    val Standby Current Consumption: String,
//    val Standby Time: String,
//    val Style: String,
//    val Talk Time: String,
//    val Type: String,
//    val Voltage: String,
//    val Wireless Charging: String,
//    val Wireless Charging Power: String
//)
//
//data class Cellular(
//    val Dual Sim Type: String,
//    val SIM Frequencies: String,
//    val SIM II Frequencies: String,
//    val SIM II Mobile Data: String,
//    val SIM II Module: String,
//    val SIM II Slot: String,
//    val SIM Mobile Data: String,
//    val SIM Module: String,
//    val SIM Slot: String
//)
//
//data class Location(
//    val GPS Feature(s): String,
//    val Module: String,
//    val Navigation: String,
//    val Parallel GPS Channels: String
//)
//
//data class Processor(
//    val CPU: String,
//    val CPU Clock Speed: String,
//    val GPU: String,
//    val GPU Clock Speed: String,
//    val GPU Dedicated Memory: String,
//    val GPU Framebuffer: String
//)
//
//data class RAM(
//    val Capacity: String,
//    val Clock Speed: String,
//    val Module: String,
//    val Type: String
//)
//
//data class SAR(
//    val Body (EU): String,
//    val Body (USA): String,
//    val Head (EU): String,
//    val Head (USA): String,
//    val Hotspot (USA): String
//)
//
//data class Sensors(
//    val Present: String
//)
//
//data class Software(
//    val Kernel Version: String,
//    val OS: String,
//    val OS Version: String
//)
//
//data class Storage(
//    val Bus Speed: String,
//    val Capacity: String,
//    val Expansion: String,
//    val Module: String,
//    val Type: String
//)
//
//data class Wireless(
//    val Bluetooth Module: String,
//    val Bluetooth Profiles: String,
//    val Bluetooth Version: String,
//    val Experience(s): String,
//    val WLAN Module: String,
//    val WMAN: String,
//    val WiFi: String,
//    val WiFi Feature(s): String
//)
//
//data class Audio(
//    val ADC Frequency: String,
//    val ADC Resolution: String,
//    val AV Out: String,
//    val AV Resolution: String,
//    val Channel: String,
//    val DAC Frequency: String,
//    val DAC Resolution: String,
//    val Hearing Aid Compatibility: String,
//    val Loudspeaker Power: String,
//    val Loudspeaker(s): String,
//    val Microphone Input: String,
//    val Microphone(s): String,
//    val Module: String,
//    val Output: String
//)
//
//data class Experiences(
//    val Present: String
//)
//
//data class Peripherals(
//    val Present: String
//)
//
//data class Ports(
//    val Ethernet: String,
//    val Ethernet Standard: String,
//    val Fax Modem Standard: String,
//    val Modem: String,
//    val Modem Standard: String,
//    val Serial Bit Rate: String,
//    val Serial Connector: String,
//    val Serial Standard: String,
//    val USB Feature(s): String,
//    val USB Features (Port II): String,
//    val USB Type: String,
//    val USB Type (Port II): String,
//    val USB Version: String,
//    val USB Version (Port II): String
//)