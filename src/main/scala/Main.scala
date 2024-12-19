
private val STANDARD = "STANDARD"
private val SPECIAL = "SPECIAL"
private val REJECTED = "REJECTED"
private val PACKAGE_HEAVY_KILOGRAM_THRESHOLD = 20
private val PACKAGE_BULKY_CENTIMETER_SIDE = 150
private val PACKAGE_BULKY_CENTIMETER_VOLUME = 1000000

//
// I am using an Integer to represent the dimensions and mass ... if anything remotely 
// approaches 2^32 cm^3 or kg, then we have bigger problems with being able to ship
//
// However, if Thoughtful does indeed deal with shipping at that scale, then we can 
// have types changed to either `Long` or `BigInteger`, and it should just work.
// It would be fascinating to live in a world where we would deal with those scales...
//
def sort(width: Int, height: Int, length: Int, mass: Int): String = 
  // Checking to make sure we are not dealing with zero or negative input.
  //
  // I was thinking of marking this as REJECTED, but it probably should be
  // brought to the attention of team that we are dealing with zero volume
  // or negative mass - I am sure the theoretical physics community especially 
  // would be thrilled to find out that we are dealing with negative mass!
  if width < 1 || height < 1 || length < 1 || mass < 0 then 
    throw Error("Cannot have either of the dimensions measure of 0, or negative mass!")

  val isHeavy = isPackageHeavy(mass)
  val isBulky = isPackageBulky(width, height, length)

  if isHeavy && isBulky then
    REJECTED
  else if isHeavy || isBulky then 
    SPECIAL
  else 
    STANDARD 

private def isPackageHeavy(mass: Int): Boolean = 
  mass >= PACKAGE_HEAVY_KILOGRAM_THRESHOLD

private def isPackageBulky(width: Int, height: Int, length: Int): Boolean = 
  width >= PACKAGE_BULKY_CENTIMETER_SIDE || 
  height >= PACKAGE_BULKY_CENTIMETER_SIDE ||
  length >= PACKAGE_BULKY_CENTIMETER_SIDE ||
  width * height * length >= PACKAGE_BULKY_CENTIMETER_VOLUME


