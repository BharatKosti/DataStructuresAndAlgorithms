package week2;
import java.util.*;
import java.util.stream.Collectors;

public class CoveringSegments {

    private static List<Integer> optimalPoints(Segment[] segments) {
        //write your code here
        int[] points = new int[2 * segments.length];
        /*for (int i = 0; i < segments.length; i++) {
            points[2 * i] = segments[i].start;
            points[2 * i + 1] = segments[i].end;
        }*/
        List<Segment> sortedSegments = Arrays.stream(segments).sorted(Comparator.comparingInt(s1 -> s1.end)).collect(Collectors.toList());
        return optimalPoints(sortedSegments,new ArrayList<>());
    }

    private static List<Integer> optimalPoints(List<Segment> segmentsList,List<Integer> optimalPoints){
        if(segmentsList.isEmpty()){
            return optimalPoints;
        }
        Segment head = segmentsList.get(0);
        Integer optimalPoint = segmentsList.stream()
                .filter(s -> s.start <= head.end)
                .map(s -> s.start)
                .max(Integer::compareTo).get();
        optimalPoints.add(optimalPoint);
        List<Segment> remainingSegments = segmentsList.stream().filter(s -> s.start > head.end).collect(Collectors.toList());
        return optimalPoints(remainingSegments,optimalPoints);
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        List<Integer> integers = optimalPoints(segments);
        int[] points = integers.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
