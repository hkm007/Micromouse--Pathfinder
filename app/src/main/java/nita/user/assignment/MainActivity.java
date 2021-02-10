package nita.user.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import co.ceryle.fitgridview.FitGridView;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    private ArrayList<AdopterItems> adopterItems;
    Button start;
    TextView xy00,xy01,xy02,xy03,xy04,xy05,xy10,xy11,xy12,xy13,xy14,xy15,xy20,xy21,xy22,xy23,xy24,xy25
            ,xy30,xy31,xy32,xy33,xy34,xy35,xy40,xy41,xy42,xy43,xy44,xy45,xy50,xy51,xy52,xy53,xy54,xy55;
    private RecyclerView.Adapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycler_view);
        layoutManager=new GridLayoutManager(this,6);
        recyclerView.setLayoutManager(layoutManager);
        adopterItems=new ArrayList<>();
        for (int i=0;i<48;i++)
            adopterItems.add(new AdopterItems(0,0));
        mAdapter=new AdopterClass(adopterItems,this);
        recyclerView.setAdapter(mAdapter);
        start=findViewById(R.id.start);
        xy00=findViewById(R.id.xy00);
        xy01=findViewById(R.id.xy01);
        xy11=findViewById(R.id.xy11);
        xy12=findViewById(R.id.xy12);
        xy13=findViewById(R.id.xy13);
        xy23=findViewById(R.id.xy23);
        xy33=findViewById(R.id.xy33);
        xy34=findViewById(R.id.xy34);
        xy44=findViewById(R.id.xy44);
        xy54=findViewById(R.id.xy54);
        xy55=findViewById(R.id.xy55);
        xy00.setBackgroundColor(Color.BLUE);
        xy55.setBackgroundColor(Color.GREEN);


        class Node
        {
            // `(x, y)` represents coordinates of a cell in the matrix
            int x, y;

            // maintain a parent node for printing the final path
            Node parent;

            Node(int x, int y, Node parent) {
                this.x = x;
                this.y = y;
                this.parent = parent;
            }

            @Override
            public String toString() {
                return "(" + x + ", " + y + ')';
            }
        }

        class Main
        {
            // `N Ã N` matrix
            private static int N;

            // Below arrays detail all four possible movements from a cell
            private static int[] row = { -1, 0, 0, 1 };
            private static int[] col = { 0, -1, 1, 0 };

            // The function returns false if pt is not in a valid position
            private static boolean isValid(int x, int y) {
                return (x >= 0 && x < N) && (y >= 0 && y < N);
            }

            // Find the shortest route in a matrix from source cell `(x, y)` to
            // destination cell `(N-1, N-1)`
            public static Node findPath(int matrix[][], int x, int y)
            {
                // create a queue and enqueue the first node
                Queue<Node> q = new ArrayDeque<>();
                Node src = new Node(x, y, null);
                q.add(src);

                // set to check if the matrix cell is visited before or not
                Set<String> visited = new HashSet<>();

                String key = src.x + "," + src.y;
                visited.add(key);

                // loop till queue is empty
                while (!q.isEmpty())
                {
                    // dequeue front node and process it
                    Node curr = q.poll();
                    int i = curr.x, j = curr.y;

                    // return if the destination is found
                    if (i == N - 1 && j == N - 1) {
                        return curr;
                    }

                    // value of the current cell
                    int n = matrix[i][j];

                    // check all four possible movements from the current cell
                    // and recur for each valid movement
                    for (int k = 0; k < 4; k++)
                    {
                        // get next position coordinates using the value of the current cell
                        x = i + row[k] * n;
                        y = j + col[k] * n;

                        // check if it is possible to go to the next position
                        // from the current position
                        if (isValid(x, y))
                        {
                            // construct the next cell node
                            Node next = new Node(x, y, curr);

                            key = next.x + "," + next.y;

                            // if it is not visited yet
                            if (!visited.contains(key)) {
                                // enqueue it and mark it as visited
                                q.add(next);
                                visited.add(key);
                            }
                        }
                    }
                }

                // return null if the path is not possible
                return null;
            }

            // Utility function to print path from source to destination
            private static int printPath(Node node) {
                if (node == null) {
                    return 0;
                }
                int len = printPath(node.parent);
                System.out.print(node + " ");
                return len + 1;
            }

            public static void main(String[] args)
            {
                int[][] matrix =
                        {
                                // { 1, 1, 0, 1, 0, 0, 0, 1, 1, 0 },
                                // { 1, 1, 0, 1, 1, 0, 1, 1, 1, 0 },
                                // { 1, 1, 0, 1, 1, 1, 1, 1, 0, 0 },
                                // { 1, 1, 1, 1, 1, 1, 0, 1, 1, 1 },
                                // { 1, 0, 1, 1, 1, 1, 0, 0, 0, 1 },
                                // { 1, 0, 1, 1, 1, 1, 1, 1, 0, 1 },
                                // { 1, 0, 1, 1, 1, 1, 1, 1, 0, 1 },
                                // { 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
                                // { 0, 1, 1, 1, 1, 0, 1, 1, 1, 0 },
                                // { 1, 0, 1, 1, 1, 0, 0, 0, 1, 1 }
                                { 1,1,0,0,1,0 },
                                { 1,1,1,1,1,1 },
                                { 0,0,1,1,0,0 },
                                { 1,1,1,1,1,1 },
                                { 1,1,0,0,1,0 },
                                { 0,1,1,1,1,1 }
                        };

                N = matrix.length;

                // Find a route in the matrix from source cell `(0, 0)` to
                // destination cell `(N-1, N-1)`
                Node node = findPath(matrix, 0, 0);


            }
        }
        final int i=1;
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CountDownTimer(11000, 1000) {
                    @Override
                    public void onTick(long l) {
                        xy00.setText(""+l/100);
                        Log.v("tag",(""+l/100));

                        if (l/1000==10)
                        {
                            xy01.setBackgroundColor(Color.RED);
                        }
                        else if (l/1000==9)
                        {
                            xy11.setBackgroundColor(Color.RED);
                        }
                        else if (l/1000==8)
                        {
                            xy12.setBackgroundColor(Color.RED);
                        }
                        else if (l/1000==7)
                        {
                            xy13.setBackgroundColor(Color.RED);
                        }
                        else if (l/1000==6)
                        {
                            xy23.setBackgroundColor(Color.RED);
                        }
                        else if (l/1000==5)
                        {
                            xy33.setBackgroundColor(Color.RED);
                        }
                        else if (l/1000==4)
                        {
                            xy34.setBackgroundColor(Color.RED);
                        }
                        else if (l/1000==3)
                        {
                            xy44.setBackgroundColor(Color.RED);
                        }
                        else if (l/1000==2)
                        {
                            xy54.setBackgroundColor(Color.RED);
                        }


                    }

                    @Override
                    public void onFinish() {

                    }
                }.start();
            }
        });

    }
}