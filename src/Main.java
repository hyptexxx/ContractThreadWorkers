import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Document> documents = new ArrayList<>();
        QueueHelper queueHelper = new QueueHelper();
        for (int i = 0; i <= 100; i++) {
            documents.add(new Document(i, i, "task" + i, TaskTypes.IN_ORDER));
        }
        for (Document document : documents) {
            if (queueHelper.getSize() < 4) {
                if (queueHelper.isErrorsExists()) {
                    queueHelper.clearQueue();
                    while (queueHelper.getErrorDocuments().size() != 0) {
                        queueHelper.addToQueue(queueHelper.getErrorDocuments().poll());
                    }
                }
                if (queueHelper.getSize() < 4) {
                    queueHelper.addToQueue(document);
                }
            } else {
                while (queueHelper.getSize() != 0) {
                    System.out.println(Objects.requireNonNull(queueHelper.getQueue().peek()).getId()
                            + "\t" +
                            Objects.requireNonNull(queueHelper.getQueue().peek()).getTask_status());
                    new Worker(Objects.requireNonNull(queueHelper.getQueue().poll()), queueHelper).start();
                }
                System.out.println("\n\n");
            }
        }
        for (Document document : documents) {
            System.out.println(document.getId() + "\t" + document.getTask_status());
        }
    }
}