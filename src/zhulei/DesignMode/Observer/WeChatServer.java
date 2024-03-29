package zhulei.DesignMode.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zl
 * @Date: 2019/4/2 11:27
 * @Description: 具体被观察者角色(ConcreteSubject)：
 *              也就是一个具体的主题，在集体主题的内部状态改变时，所有登记过的观察者发出通知。
 */
public class WeChatServer implements Observerable{

    //注意到这个List集合的泛型参数为Observer接口，设计原则：面向接口编程而不是面向实现编程
    private List<Observer> list;
    private String message;

    public WeChatServer() {
        list = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer o) {
        list.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        list.remove(o);
    }

    @Override
    public void notifyObserver() {
        for(int i = 0; i < list.size(); i++) {
            Observer observer = list.get(i);
            observer.update(message);
        }
    }

    public void setInfomation(String s) {
        this.message = s;
        System.out.println("微信服务更新消息： " + s);
        //消息更新，通知所有观察者
        notifyObserver();
    }
}
