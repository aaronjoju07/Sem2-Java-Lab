import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BookingThread extends Thread {
    private static int bookingCount = 0;
    private static final Lock lock = new ReentrantLock();

    @Override
    public void run() {
        // Simulating a user making a booking
        makeBooking();
    }

    private void makeBooking() {
        // Assume some booking logic here
        // For simplicity, we'll just increment a counter
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

        // Create and start multiple threads
        BookingThread[] bookingThreads = new BookingThread[numUsers];
        for (int i = 0; i < numUsers; i++) {
            bookingThreads[i] = new BookingThread();
            bookingThreads[i].start();
        }

        // Wait for all threads to finish
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
