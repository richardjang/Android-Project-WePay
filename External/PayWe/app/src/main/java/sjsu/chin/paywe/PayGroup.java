package sjsu.chin.paywe;

/**
 * Created by Cann on 11/29/2015.
 */
import android.content.Context;
import android.support.annotation.NonNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.UUID;

public class PayGroup {
    private static PayGroup sPayGroup;
    private List<Pay> mPays;



    public static PayGroup get(Context context) {
        if (sPayGroup == null){
            sPayGroup = new PayGroup(context);
        }
        return sPayGroup;
    }
    private PayGroup(Context context) {
        mPays = new List<Pay>() {
            @Override
            public void add(int location, Pay object) {

            }

            @Override
            public boolean add(Pay object) {
                return false;
            }

            @Override
            public boolean addAll(int location, Collection<? extends Pay> collection) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Pay> collection) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean contains(Object object) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> collection) {
                return false;
            }

            @Override
            public Pay get(int location) {
                return null;
            }

            @Override
            public int indexOf(Object object) {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @NonNull
            @Override
            public Iterator<Pay> iterator() {
                return null;
            }

            @Override
            public int lastIndexOf(Object object) {
                return 0;
            }

            @Override
            public ListIterator<Pay> listIterator() {
                return null;
            }

            @NonNull
            @Override
            public ListIterator<Pay> listIterator(int location) {
                return null;
            }

            @Override
            public Pay remove(int location) {
                return null;
            }

            @Override
            public boolean remove(Object object) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> collection) {
                return false;
            }

            @Override
            public Pay set(int location, Pay object) {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }

            @NonNull
            @Override
            public List<Pay> subList(int start, int end) {
                return null;
            }

            @NonNull
            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @NonNull
            @Override
            public <T> T[] toArray(T[] array) {
                return null;
            }
        };
        for(int i = 0; i < 10; i++){
            Pay pay = new Pay();
            pay.setmTitle("Group #" +i);
            pay.setmSolved(i%2 == 0);
            mPays.add(pay);
        }
    }

    public List<Pay>getmPays() {
        return mPays;
    }

    public Pay getPay(UUID id){
        for(Pay pay: mPays){
            if(pay.getmId().equals(id)){
                return pay;
            }
        }
        return null;
    }

}
