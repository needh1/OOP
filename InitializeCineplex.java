public class InitializeCineplex extends Initializer
{
    public final void initialize(){
        CineplexStorage storage = new CineplexStorage();

        Cineplex cineplexA = new Cineplex("Cineplex A");
        cineplexA.addCinema("A01", CinemaType.STANDARD, 8, 8);
        cineplexA.addCinema("A02", CinemaType.STANDARD, 8, 8);
        cineplexA.addCinema("A03", CinemaType.PREMIUM, 8, 8);

        Cineplex cineplexB = new Cineplex("Cineplex B");
        cineplexB.addCinema("B01", CinemaType.STANDARD, 8, 8);
        cineplexB.addCinema("B02", CinemaType.STANDARD, 8, 8);
        cineplexB.addCinema("B03", CinemaType.PREMIUM, 8, 8);

        Cineplex cineplexC = new Cineplex("Cineplex C");
        cineplexC.addCinema("C01", CinemaType.STANDARD, 8, 8);
        cineplexC.addCinema("C02", CinemaType.STANDARD, 8, 8);
        cineplexC.addCinema("C03", CinemaType.PREMIUM, 8, 8);

        storage.writeObject(cineplexA);
        storage.writeObject(cineplexB);
        storage.writeObject(cineplexC);
    }
}
