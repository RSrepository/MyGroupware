package rsrepo.groupware.mygroupware.domain.model;

import javax.validation.GroupSequence;
import rsrepo.groupware.mygroupware.domain.model.ValidGroups.*;

// グループの実行順序
@GroupSequence({ ValidGroup1.class, ValidGroup2.class, ValidGroup3.class })
public interface GroupOrder {
}