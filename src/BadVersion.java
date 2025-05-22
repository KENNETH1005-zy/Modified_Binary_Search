public class BadVersion {
    // Store the first bad version
    protected int badVersion;

    public BadVersion(int v) {
        this.badVersion = v;
    }

    public boolean isBadVersion(int version) {
        // Return true if version is bad
        return version >= badVersion;
    }
}