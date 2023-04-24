import java.util.ArrayList;
import java.util.List;

class NewsAgency {
    private String newsContent;
    private int time;
    private List<NewsSubscriber> list = new ArrayList<NewsSubscriber>();

    public void setNewsUpdates(String newsContent, int time) {
        this.newsContent = newsContent;
        this.time = time;
        notifyAllSubscribers();
    }

    public String getContent() {
        return newsContent;
    }

    public int getTime() {
        return time;
    }

    public void addSubscriber(NewsSubscriber ns) {
        list.add(ns);
    }
    public void removeSubscriber(NewsSubscriber ns) {
        list.remove(ns);
    }

    public void notifyAllSubscribers() {
        for(NewsSubscriber ns : list) {
            ns.update();
        }
    }
}

abstract class NewsSubscriber {
    NewsAgency na;
    abstract public void update();
}

class MorningNewsBulletin extends NewsSubscriber {
    public MorningNewsBulletin(NewsAgency n) {
        na = n;
    }
    @Override
    public void update() {
        String content = na.getContent();
        int time = na.getTime();
        if(time >= 7 && time <= 12) {
            System.out.println("Morning News : " + content + " at time : " + time);
        }
    }
}

class EveningNewsBulletin extends NewsSubscriber {
    public EveningNewsBulletin(NewsAgency n) {
        na = n;
    }
    @Override
    public void update() {
        String content = na.getContent();
        int time = na.getTime();
        if(time >= 4 && time <= 7) {
            System.out.println("Evening News : " + content + " at time : " + time);
        }
    }
}

public class NewsObserver {
    public static void main(String[] args) {
        NewsAgency na = new NewsAgency();
        NewsSubscriber ns1 = new MorningNewsBulletin(na);
        NewsSubscriber ns2 = new EveningNewsBulletin(na);
        na.addSubscriber(ns1);
        na.addSubscriber(ns2);
        na.setNewsUpdates("Crime",5);
        na.setNewsUpdates("Motivation",9);
    }
}