Θεμελειώδεις αρχές βάσεων δεδομένων Elmasri & s.b. navathe 7η εκδοση εκδοσεις διαυλος 

Database -> Tablespace -> Segment -> Extent -> Block (-> περιέχει) 

Page 

Block 

Block 

Block 

... 

Λογική οργάνωση 

-   Extent είναι ένα σύνολο απο συνεχόμενα blocks 
    

-   Segment είναι ένα σύνολο από extnet που αντιστοιχούν σε μια λογική οντότητα. 
    

# Δομή του block 

Το block είναι η μικροότερη μονάδα Ι/Ο της βδ 

-   Header : σε τι segment βρίσκεται το block 
    
-   Table dir : ποιος πίνακας έχει εγγραφές στο block 
    
-   Row dir : οι δ/σεις των εγγραφών στο block 
    
-   Row data : οι εγγγραφές 
    

Μας ενδιαφέρει να ξέρουμε πόσα μπλοκ θέλουμε να φέρουμε από την μνήμη, όσο το λιγότερο τόσο το καλύτερο (query optimization) <- πολυπλοκότητα

*ujvjtbtvkfjvbfb*

**fljvndkjfvdjkfbvn**

**ljkrtngkjfnblknrgdojrnbflvmrlkgb**
kjrbfdkhvbdfnvdbvnd
#j
