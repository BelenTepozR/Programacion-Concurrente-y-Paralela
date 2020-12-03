
package JDrones;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class varCondition {
        private Lock variableCondition;
           private Lock vc;
           private Condition condition;
        varCondition(){
                variableCondition = new ReentrantLock();
                condition = variableCondition.newCondition();
        }
        public void Acquire(){
                
        }
        public void Relase(){
                
        }
}
