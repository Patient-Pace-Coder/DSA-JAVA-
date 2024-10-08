package Arrays;

public class IsUnique {

    public boolean isUnique(int arr[]){

        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]==arr[j]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsUnique obj=new IsUnique();
        int arr[]={20,30,10,40,50,60};
        System.out.println(obj.isUnique(arr));
    }
}
