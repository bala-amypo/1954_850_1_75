@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Visitor {

    @Id
    @GeneratedValue
    private Long id;

    private String fullName;
    private String phone;
    private String email;
    private String idProof;
}
