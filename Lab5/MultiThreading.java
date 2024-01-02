import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BookingThread extends Thread {
    private static int bookingCount = 0;
    private static final Lock lock = new ReentrantLock();

    @Override
    public void run() {
        makeBooking();
    }

    private void makeBooking() {
        lock.lock();
        try {
            bookingCount++;
            System.out.println("Booking made by user " + Thread.currentThread().getId() +
                    ". Total bookings: " + bookingCount);
        } finally {
            lock.unlock();
        }
    }
}

public class MultiThreading {
    public static void main(String[] args) {
        int numUsers = 5;

        BookingThread[] bookingThreads = new BookingThread[numUsers];
        for (int i = 0; i < numUsers; i++) {
            bookingThreads[i] = new BookingThread();
            bookingThreads[i].start();
        }

        try {
            for (BookingThread thread : bookingThreads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All bookings completed.");
    }
}
