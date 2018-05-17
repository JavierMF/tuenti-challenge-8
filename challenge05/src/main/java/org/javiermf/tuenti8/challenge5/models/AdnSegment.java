package org.javiermf.tuenti8.challenge5.models;

import lombok.Data;

@Data
public class AdnSegment {

    final int pos;
    final String contents;

    public boolean startsLike(AdnSegment adnSegment) {
        return !this.equals(adnSegment) &&
                (contents.startsWith(adnSegment.contents) ||
                        adnSegment.contents.startsWith(contents)
                );
    }

    public boolean matchesStart(String difference) {
        return contents.startsWith(difference) || difference.startsWith(contents);
    }
}
