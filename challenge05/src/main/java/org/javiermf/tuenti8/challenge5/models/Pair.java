package org.javiermf.tuenti8.challenge5.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
public class Pair {

    final AdnSegment segment1;
    final AdnSegment segment2;

    public Pair(AdnSegment segment1, AdnSegment segment2) {
        if (segment1.getPos() <= segment2.getPos()) {
            this.segment1 = segment1;
            this.segment2 = segment2;
        } else {
            this.segment1 = segment2;
            this.segment2 = segment1;
        }
    }
}
