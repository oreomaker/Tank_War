package client.model;

import java.util.IllegalFormatCodePointException;
import java.util.Vector;

public class Dijkstra {
    private Vector<Point> pointCollection;
    private int[] pointNum={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36};
    private Vector<Point> pointVector=new Vector<>();
    private int[][] adjMatrix= {{0, 4, -1, -1, -1, -1, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,-1,-1,-1,-1,-1,-1,-1,-1},
            {4, 0, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,-1,-1,-1,-1,-1,-1,-1,-1},
            {-1, 3, 0, 3, -1, -1, -1, -1, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,-1,-1,-1,-1,-1,-1,-1,-1},
            {-1, -1, 3, 0, 3, -1, -1, -1, -1, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,-1,-1,-1,-1,-1,-1,-1,-1},
            {-1, -1, -1, 3, 0, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,-1,-1,-1,-1,-1,-1,-1,-1},
            {-1, -1, -1, -1, 3, 0, -1, -1, -1, -1, -1, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,-1,-1,-1,-1,-1,-1,-1,-1},
            {4, -1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,-1,-1,-1,-1,-1,-1,-1,-1},
            {-1, -1, -1, -1, -1, -1, -1, 0, 3, -1, -1, -1, -1, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,-1,-1,-1,-1,-1,-1,-1,-1},
            {-1, -1, 4, -1, -1, -1, -1, 3, 0, 3, -1, -1, -1, -1, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,-1,-1,-1,-1,-1,-1,-1},
            {-1, -1, -1, 4, -1, -1, -1, -1, 3, 0, 3, -1, -1, -1, -1, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,-1,-1,-1,-1,-1,-1,-1,-1},
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, 3, 0, -1, -1, -1, -1, -1, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,-1,-1,-1,-1,-1,-1,-1,-1},
            {-1, -1, -1, -1, -1, 4, -1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,-1,-1,-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1,3,-1,-1,-1,-1,-1,0,4,-1,-1,-1,-1,3,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1,-1,3,-1,-1,-1,-1,4,0,3,-1,-1,-1,-1,3,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1,-1,-1,3,-1,-1,-1,-1,3,0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,3,-1,-1,-1,-1,-1,0,3,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,3,-1,-1,-1,-1,3,0,4,-1,-1,-1,-1,3,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,3,-1,-1,-1,-1,4,0,-1,-1,-1,-1,-1,3,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,3,-1,-1,-1,-1,-1,0,4,-1,-1,-1,-1,3,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,3,-1,-1,-1,-1,4,0,3,-1,-1,-1,-1,3,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,3,0,-1,-1,-1,-1,-1,3,-1,-1,-1,-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,0,3,-1,-1,-1,-1,3,-1,-1,-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,3,-1,-1,-1,-1,3,0,4,-1,-1,-1,-1,3,-1,-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,3,-1,-1,-1,-1,4,0,-1,-1,-1,-1,-1,3,-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,3,-1,-1,-1,-1,-1,0,-1,-1,-1,-1,-1,4,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,3,-1,-1,-1,-1,-1,0,3,-1,-1,-1,-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,3,-1,-1,-1,-1,3,0,3,-1,-1,-1,-1,4,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,3,-1,-1,-1,-1,3,0,3,-1,-1,-1,-1,4,-1,-1},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,3,-1,-1,-1,-1,3,0,-1,-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,3,-1,-1,-1,-1,-1,0,-1,-1,-1,-1,-1,4},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,4,-1,-1,-1,-1,-1,0,4,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,4,0,3,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,4,-1,-1,-1,-1,3,0,3,-1,-1},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,4,-1,-1,-1,-1,3,0,3,-1},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,3,0,4},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,4,-1,-1,-1,-1,4,0}

    };

    public Point getShortestPaths(int start,int end) {
        int[] result = new int[adjMatrix.length];   //??????????????????0??????????????????????????????
        boolean[] used = new boolean[adjMatrix.length];  //?????????????????????????????????
        int refreshed=Integer.MAX_VALUE;//?????????????????????
        for (int i=0;i<adjMatrix.length;i++) {//??????????????????result?????????start-1?????????0??????????????????????????????start-1??????used?????????false.refreshed???????????????start-1???
            if (i!=(start-1)){
                result[i]=Integer.MAX_VALUE;
                used[i]=false;
            }else {//???????????????
                result[i]=0;
                refreshed=start-1;
                used[i]=true;
                pointCollection.get(start-1).setPrePoint(null);
            }
        }
        while(true){
            for (int i=0;i<adjMatrix.length;i++){
                if (adjMatrix[refreshed][i]!=-1&&!used[i]){//???refreshed???????????????????????????????????????????????????
                    if (result[i]>adjMatrix[refreshed][i]+result[refreshed]){
                        result[i]=adjMatrix[refreshed][i]+result[refreshed];//???result[i]<adjMatrix[refreshed][i]+result[refreshed],????????????????????????result[i]???adjMatrix[refreshed][i]+result[refreshed]
                        pointCollection.get(i).setPrePoint(pointCollection.get(refreshed));//??????????????????refreshed
                    }
                }
            }
            //??????????????????????????????result??????????????????????????????refreshed
            int min=Integer.MAX_VALUE;
            int k=0;
            for (int i=0;i<adjMatrix.length;i++){
                if (!used[i]&&result[i]<min){
                   k=i;
                   min=result[i];
                }
            }
            used[k]=true;
            refreshed=k;
            if (used[end-1]){
                return pointCollection.get(end-1);
            }
        }
    }
    public Vector<Point> formVector(int start,int end){
        Point endP=getShortestPaths(start,end);
        Vector<Point> reverseSeries=new Vector<>();
        Vector<Point> series=new Vector<>();
        reverseSeries.add(endP);
        while(true){
            if (reverseSeries.get(reverseSeries.size()-1).getPrePoint()==null){
                break;
            }else {
                reverseSeries.add(reverseSeries.get(reverseSeries.size() - 1).getPrePoint());
            }
        }
        for (int i=reverseSeries.size()-1;i>=0;i--){
            series.add(reverseSeries.get(i));
        }
        return series;
    }
    public Vector<Point> addPoints(){
        Vector<Point> points=new Vector<>();
        points.add(new Point(points.size()+1,25,25,2,7));
        points.add(new Point(points.size()+1,125,25,1,3));
        points.add(new Point(points.size()+1,200,25,2,4,9));
        points.add(new Point(points.size()+1,275,25,3,5,10));
        points.add(new Point(points.size()+1,350,25,4,6));
        points.add(new Point(points.size()+1,450,25,5,12));
        points.add(new Point(points.size()+1,25,125,1,13));
        points.add(new Point(points.size()+1,125,125,9,14));
        points.add(new Point(points.size()+1,200,125,3,8,10,15));
        points.add(new Point(points.size()+1,275,125,4,9,11,16));
        points.add(new Point(points.size()+1,350,125,10,17));
        points.add(new Point(points.size()+1,450,125,6,18));
        points.add(new Point(points.size()+1,25,200,7,14,19));
        points.add(new Point(points.size()+1,125,200,8,13,15,20));
        points.add(new Point(points.size()+1,200,200,9,14));
        points.add(new Point(points.size()+1,275,200,10,17));
        points.add(new Point(points.size()+1,350,200,11,16,18,23));
        points.add(new Point(points.size()+1,450,200,12,17,24));
        points.add(new Point(points.size()+1,25,275,13,20,25));
        points.add(new Point(points.size()+1,125,275,14,19,21,26));
        points.add(new Point(points.size()+1,200,275,20,27));
        points.add(new Point(points.size()+1,275,275,23,28));
        points.add(new Point(points.size()+1,350,275,17,22,24,29));
        points.add(new Point(points.size()+1,450,275,18,23,30));
        points.add(new Point(points.size()+1,25,350,19,31));
        points.add(new Point(points.size()+1,125,350,20,27));
        points.add(new Point(points.size()+1,200,350,21,26,28,33));
        points.add(new Point(points.size()+1,275,350,22,27,29,34));
        points.add(new Point(points.size()+1,350,350,23,28));
        points.add(new Point(points.size()+1,450,350,24,36));
        points.add(new Point(points.size()+1,25,450,25,32));
        points.add(new Point(points.size()+1,125,450,31,33));
        points.add(new Point(points.size()+1,200,450,27,32,34));
        points.add(new Point(points.size()+1,275,450,28,33,35));
        points.add(new Point(points.size()+1,350,450,34,36));
        points.add(new Point(points.size()+1,450,450,30,35));
        return points;
    }

    public Dijkstra() {
        pointCollection=addPoints();
    }
    public void resetFlag(){
        for (int i=0;i<36;i++){
            pointCollection.get(i).setFlag(true);
        }
    }

    public Vector<Point> getPointCollection() {
        return pointCollection;
    }
}
