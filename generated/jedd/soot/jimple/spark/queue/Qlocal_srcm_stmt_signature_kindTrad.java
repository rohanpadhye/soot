package soot.jimple.spark.queue;

import soot.util.*;
import soot.jimple.spark.bdddomains.*;
import soot.jimple.spark.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public class Qlocal_srcm_stmt_signature_kindTrad extends Qlocal_srcm_stmt_signature_kind {
    private ChunkedQueue q = new ChunkedQueue();
    
    public void add(Local _local, SootMethod _srcm, Unit _stmt, NumberedString _signature, Kind _kind) {
        q.add(_local);
        q.add(_srcm);
        q.add(_stmt);
        q.add(_signature);
        q.add(_kind);
    }
    
    public void add(final jedd.internal.RelationContainer in) {
        Iterator it =
          new jedd.internal.RelationContainer(new Attribute[] { signature.v(), local.v(), kind.v(), stmt.v(), srcm.v() },
                                              new PhysicalDomain[] { H2.v(), V1.v(), FD.v(), ST.v(), T1.v() },
                                              ("in.iterator(new jedd.Attribute[...]) at /home/olhotak/soot-2" +
                                               "-jedd/src/soot/jimple/spark/queue/Qlocal_srcm_stmt_signature" +
                                               "_kindTrad.jedd:40,22"),
                                              in).iterator(new Attribute[] { local.v(), srcm.v(), stmt.v(), signature.v(), kind.v() });
        while (it.hasNext()) {
            Object[] tuple = (Object[]) it.next();
            for (int i = 0; i < 5; i++) { q.add(tuple[i]); }
        }
    }
    
    public Rlocal_srcm_stmt_signature_kind reader() { return new Rlocal_srcm_stmt_signature_kindTrad(q.reader()); }
    
    public Qlocal_srcm_stmt_signature_kindTrad() { super(); }
}