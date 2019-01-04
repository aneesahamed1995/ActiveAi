package app.demo.com.activeai;

import java.util.List;

public class SelectionSorter {
    SortObserver sortObserver;
    public SelectionSorter(SortObserver sortObserver){
        this.sortObserver = sortObserver;
    }

    public void sortArray(List<Integer> list){
        Integer [] arr = list.toArray(new Integer[list.size()]);
        boolean isFinal = true;
        int temp =0;
        for(int i=0 ;i<arr.length;i++){
            temp = i;
            for (int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[i]){
                    temp = j;
                }
            }
            if(temp!=i){
                int mTemp = arr[i];
                arr[i] = arr[temp];
                arr[temp] = mTemp;
                isFinal = false;
                break;
            }
        }
        if(!isFinal){
            sortObserver.onArrayUpdate(arr);
        }
        else {
            sortObserver.onFinish();
        }
    }
}
