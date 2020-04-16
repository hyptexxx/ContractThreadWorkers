import java.util.Random;

class Worker extends Thread {
    private Document document;
    private QueueHelper queueHelper;

    Worker(Document document, QueueHelper queueHelper) {
        super(document.getTask());
        this.document = document;
        this.queueHelper = queueHelper;
    }

    @Override
    public void run() {
        document.setTask_status(TaskTypes.IN_WORK);
        switch (getRandomNumberInRange(1, 2)) {
            case 1: {
                if (getRandomNumberInRange(1, 2) == 1) {
                    document.setTask_status(TaskTypes.ERROR);
                    queueHelper.addToError(document);
                    Thread.currentThread().interrupt();
                }
            }break;
            case 2: {
                document.setTask_status(TaskTypes.COMPLETED);
                Thread.currentThread().interrupt();
            }break;
        }
        if (document.getTask_status() != TaskTypes.ERROR) {
            document.setTask_status(TaskTypes.COMPLETED);
            queueHelper.clearQueueError();
        }
    }

    private static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}