import java.util.LinkedList;
import java.util.Queue;
  public class RoomSearch {
        // الدالة التكرارية للبحث عن غرض في الغرف
        public boolean searchItemIterative(int[][] rooms, int target) {
            int m = rooms.length; // عدد الصفوف
            int n = rooms[0].length; // عدد الأعمدة
            int row = 0; // المؤشر الأفقي
            int col = n - 1; // المؤشر العمودي
            while (row < m && col >= 0) {
                if (rooms[row][col] == target) {
                    return true; // تم العثور على الغرفة المطلوبة
                } else if (rooms[row][col] > target) {
                    col--; // انتقال للغرفة المجاورة على اليسار
                } else {
                    row++; // انتقال للغرفة المجاورة أسفل
                }
            }
            return false; // لم يتم العثور على الغرفة المطلوبة
        }
        // الدالة العودية للبحثعن غرض في الغرف
        public boolean searchItemRecursive(int[][] rooms, int target, int row, int col) {
            int m = rooms.length;
            int n = rooms[0].length;

            if (row >= rooms.length || col < 0) {
                return false; // تجاوز حدود المجموعة
            }

            if (rooms[row][col] == target) {
                return true; // تم العثور على الغرفة المطلوبة
            }

            if (rooms[row][col] > target) {
                return searchItemRecursive(rooms, target, row, col - 1); // انتقال للغرفة المجاورة على اليسار
            } else {
                return searchItemRecursive(rooms, target, row + 1, col); // انتقال للغرفة المجاورة أسفل
            }
        }
        //todo الطلب الثاني من المسألة
        // الدالة التكرارية للبحث في الغرف عن طريق الرقم
        public int searchRoomIterative(int[][] rooms, int targetDistance) {
            int m = rooms.length;
            int n = rooms[0].length;
            int row = 0;
            int col = n-1;
            while (row < m && col >= 0) {
                if (rooms[row][col] == targetDistance) {
                    return 0; // تم العثور على الغرفة المطلوبة
                } else if (rooms[row][col] > targetDistance ||  rooms[row][col] == -1) {
                    col --;   // انتقال للغرفة المجاورة على اليسار
                } else  {
                    row ++; // انتقال للغرفة المجاورة أسفل
                }
            }

            return -1; // لم يتم العثور على الغرفة المطلوبة
        }

        //  الدالة العودية للبحث في الغرف عن طريق الرقم
        public int searchRoomRecursive(int[][] rooms, int targetDistance ,int row , int col ) {
            if (row >= rooms.length || col < 0) {
                return -1; // Item not found
            }
            if (rooms[row][col] == targetDistance) {
                return 0 ; // Item found
            } else if (rooms[row][col] > targetDistance || rooms[row][col] == -1) {
                return searchRoomRecursive(rooms, targetDistance, row, col - 1); // Move left
            } else {
                return searchRoomRecursive(rooms, targetDistance, row + 1, col); // Move down
            }
        }
        // دالة تحديد الأرقام التي يجب أن تكون موجودة في الغرف عند وضع عنصر ما في الغرفة
     public void determineRoomNumbers(int[][] rooms, int itemRow, int itemCol) {
        int m = rooms.length;
        int n = rooms[0].length;
        int[][] distance = new int[m][n];
        // تهيئة كافة المسافات ب -1 (يشير إلى الغرف التي لا يمكن الوصول إليها)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = -1;
            }
        }
        // إنشاء قائمة انتظار
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{itemRow, itemCol});
        distance[itemRow][itemCol] = 0; // المسافة من الغرفة مع العنصر هي 0
        // تحديد الاتجاهات (أعلى، أسفل، يسار، يمين)
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

         while (!queue.isEmpty()) {
            int[] currentRoom = queue.poll();
            int x = currentRoom[0];
            int y = currentRoom[1];
            // استكشاف الغرف المجاورة
            for (int k = 0; k < 4; k++) {
                int newX = x + dx[k];
                int newY = y + dy[k];
                // تحقق مما إذا كانت الغرفة المجاورة تقع ضمن حدود الشبكة
                if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                    // تحقق مما إذا كان من الممكن الوصول إلى الغرفة المجاورة وقم بتحديث المسافة بينها
                    if (distance[newX][newY] == -1 || distance[newX][newY] > distance[x][y] + 1) {
                        distance[newX][newY] = distance[x][y] + 1;
                        queue.add(new int[]{newX, newY});
                        //تحتوي المصفوفة "المسافة" الآن على أرقام المسافة المحسوبة لكل غرفة
                    }
                }
            }
         }
     }
  }








