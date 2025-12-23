
public interface AddService {
    boolean addPartyMember(PartyMember member);
    public class DefaultAddService implements AddService {

        private final AddDao addDao;
        public DefaultAddService(AddDao addDao) {
            this.addDao = addDao;
        }
        @Override
        public boolean addPartyMember(PartyMember member) {
            return addDao.addPartyMember(member);
        }
    }
}