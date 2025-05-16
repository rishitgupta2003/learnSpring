package fcc_multithreading;

public class DaemonUserThreadHelper {
    public static void main(String[] args) {
        DaemonThreadHelper daemonThreadHelper = new DaemonThreadHelper();
        UserThreadHelper userThreadHelper = new UserThreadHelper();

        daemonThreadHelper.setDaemon(true);

        daemonThreadHelper.start();
        userThreadHelper.start();
    }
}

class DaemonThreadHelper extends Thread{
    @Override
    public void run() {
        int count = 0;
        while(count < 500){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }

            count++;
            System.out.println("DaemonHelperRunning");
        }
    }
}

class UserThreadHelper extends Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }

        System.out.println("Execution Done");
    }
}